describe('API Tests', () => {
    it('should fetch user data', function ()  {
        cy.request('GET', 'http://localhost:8080/users')
            .then((response) => {
                const timestamp = new Date().toISOString().replace(/[:.]/g, '-');
                const testTitle = this.test.title.replace(/\s+/g, '_');
                const filename = `cypress/fixtures/${testTitle}_${timestamp}.json`;

                // Save the payload to a file with the timestamp in the name
                cy.writeFile(filename, response.body);
                // Assertions

                // 1. Validate status code
                expect(response.status).to.eq(200);

                // 2. Validate headers
                expect(response.headers).to.have.property('content-type', 'application/json');
                expect(response.headers).to.have.property('x-frame-options', 'DENY');
                expect(response.headers).to.have.property('cache-control', 'no-cache, no-store, max-age=0, must-revalidate');

                // 3. Validate response body structure
                expect(response.body).to.be.an('array').and.to.have.lengthOf(3);

                // 4. Validate specific values in the response body
                const expectedNames = ['bob', 'alice', 'john'];
                response.body.forEach((user, index) => {
                    expect(user).to.have.property('name', expectedNames[index]);
                });

                // 5. Validate all names are present
                const actualNames = response.body.map(user => user.name);
                expect(actualNames).to.deep.eq(expectedNames);
            });
    });
});