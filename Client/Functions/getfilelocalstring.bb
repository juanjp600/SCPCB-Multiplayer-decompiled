Function getfilelocalstring$(arg0$, arg1$, arg2$, arg3$, arg4%)
    Local local0$
    If (arg4 <> 0) Then
        local0 = inigetbufferstring(arg0, arg1, arg2, arg3)
    Else
        local0 = arg3
    EndIf
    Return inigetbufferstring((lang\Field1 + arg0), arg1, arg2, local0)
    Return ""
End Function
