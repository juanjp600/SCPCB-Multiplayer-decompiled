Function se_definepublic%(arg0$, arg1.se_token)
    Local local0.se_publicdef
    If (se_checkglobalscope(arg0) <> 0) Then
        Return $00
    EndIf
    local0 = (New se_publicdef)
    local0\Field1 = arg0
    local0\Field0 = se_vf_createpublic(arg0)
    local0\Field2 = arg1
    Return $01
    Return $00
End Function
