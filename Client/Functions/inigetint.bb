Function inigetint%(arg0$, arg1$, arg2$, arg3%, arg4%)
    Local local0$
    local0 = inigetstring(arg0, arg1, arg2, (Str arg3), arg4)
    Select local0
        Case "True","true","1"
            Return $01
        Case "False","false","0"
            Return $00
        Default
            Return (Int local0)
    End Select
    Return $00
End Function
