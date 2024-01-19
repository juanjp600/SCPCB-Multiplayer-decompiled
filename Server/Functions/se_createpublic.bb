Function se_createpublic.se_public(arg0.se_script, arg1$, arg2.se_value)
    Local local0.se_public
    local0 = (New se_public)
    local0\Field0 = arg1
    local0\Field1 = arg2
    If (arg0\Field6 <> Null) Then
        local0\Field2 = arg0\Field6
        arg0\Field6\Field3 = local0
        arg0\Field6 = local0
    Else
        arg0\Field5 = local0
        arg0\Field6 = local0
    EndIf
    Return local0
    Return Null
End Function
