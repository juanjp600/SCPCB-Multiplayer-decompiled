Function se_warn%(arg0.se_token, arg1$)
    Local local0.se_warning
    local0 = (New se_warning)
    local0\Field0 = "WARNING!"
    If (arg0 <> Null) Then
        local0\Field0 = (((("(line " + (Str arg0\Field2\Field1)) + ", column ") + (Str arg0\Field3)) + ")")
    EndIf
    local0\Field0 = ((local0\Field0 + ": ") + arg1)
    Return $00
End Function
