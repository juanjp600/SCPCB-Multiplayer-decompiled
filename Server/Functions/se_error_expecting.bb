Function se_error_expecting%(arg0.se_token, arg1$)
    se_error(arg0, ((("expecting " + arg1) + " but encountered ") + arg0\Field4), $01)
    Return $00
End Function
