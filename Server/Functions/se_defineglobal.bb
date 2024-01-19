Function se_defineglobal%(arg0$, arg1.se_token)
    Local local0.se_globaldef
    If (se_checkglobalscope(arg0) <> 0) Then
        Return $00
    EndIf
    local0 = (New se_globaldef)
    local0\Field1 = arg0
    local0\Field0 = se_vf_createstatic()
    local0\Field2 = arg1
    Return $01
    Return $00
End Function
