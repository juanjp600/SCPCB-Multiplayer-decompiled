Function se_definefunction.se_functiondef(arg0$, arg1.se_token)
    Local local0.se_functiondef
    If (se_checkfunction(arg0) <> 0) Then
        Return Null
    EndIf
    local0 = (New se_functiondef)
    local0\Field0 = se_vf_createfuncptr(arg0)
    local0\Field8 = arg1
    Return local0
    Return Null
End Function
