@param nogrend.questionnaireapp.approve.Approver approver
@param java.util.List<org.springframework.validation.FieldError> errors

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Will you approve?</title>
    <style>
        input {
            border: 1px solid #ccc;
            padding: 5px;
            box-sizing: border-box;
        }
        .error {
            color: red;
            font-size: 0.9em;
            margin-bottom: 4px;
        }

        .error-input {
            border: 1px solid red;
        }
    </style>
</head>
<body>
<h1>Hello, do you approve?</h1>
<form action="/approve" method="POST">
    <div>
        <input type="checkbox"
               name="hasApproved"
               id="approve-checkbox"
               value="${approver.hasApproved()}"/>
        <label for="approve-checkbox">I approve.</label>
    </div>

    <div>
        <label for="approver-name">My name is</label>
        <input type="text"
               name="name"
               id="approver-name"
               placeholder="enter your name"
               class="@if (errors != null && errors.stream().anyMatch(error -> error.getField().equals("name"))) error-input @endif"
               value="${approver.getName()}">
        @if (errors != null)
            @for (org.springframework.validation.FieldError error : errors)
                @if (error.getField().equals("name"))
                    <div class="error">${error.getDefaultMessage()}</div>
                @endif
            @endfor
        @endif

    </div>

    <button type="submit">I approve</button>
</form>
</body>
</html>
