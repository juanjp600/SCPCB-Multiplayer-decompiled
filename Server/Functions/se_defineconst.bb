Function se_defineconst%(arg0$, arg1%, arg2$, arg3%, arg4.se_token)
    Local local0.se_constantdef
    If (se_checkconstant(arg0) <> 0) Then
        Return $00
    EndIf
    local0 = (New se_constantdef)
    local0\Field0 = arg0
    local0\Field1 = arg1
    local0\Field2 = arg2
    local0\Field3 = arg3
    local0\Field4 = arg4
    Return $01
    Return $00
End Function
