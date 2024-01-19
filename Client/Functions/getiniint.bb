Function getiniint%(arg0$, arg1$, arg2$, arg3%)
    Local local0$
    local0 = getinistring(arg0, arg1, arg2, (Str arg3))
    If (lower(local0) = "true") Then
        Return $01
    ElseIf (lower(local0) = "false") Then
        Return $00
    Else
        Return (Int local0)
    EndIf
    Return $00
End Function
