Function loadtexture_strict%(arg0$, arg1%, arg2%)
    Local local0%
    If (arg2 = $00) Then
        local0 = loadtexture(arg0, arg1)
    Else
        local0 = createtexture($01, $01, arg1, $01)
    EndIf
    Return local0
    Return $00
End Function
