Function setcolorex%(arg0%, arg1%, arg2%)
    Local local0%
    local0 = (((arg0 Shl $10) Or (arg1 Shl $08)) Or arg2)
    If (local0 <> lastcolor) Then
        color(arg0, arg1, arg2, $FF)
        lastcolor = local0
        Return $01
    EndIf
    Return $00
    Return $00
End Function
