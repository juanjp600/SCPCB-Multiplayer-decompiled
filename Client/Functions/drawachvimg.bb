Function drawachvimg%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1#
    Local local2#
    local1 = (76.0 * achvscale)
    local2 = (64.0 * achvscale)
    local0 = (arg2 Mod $04)
    setcolorex($00, $00, $00)
    rect((Int (((Float local0) * local1) + (Float arg0))), arg1, (Int local2), (Int local2), $01)
    If (achievements(arg2) = $01) Then
        drawblock(achvimg(arg2), (Int (((Float local0) * local1) + (Float arg0))), arg1, $00)
    Else
        drawblock(achvlocked, (Int (((Float local0) * local1) + (Float arg0))), arg1, $00)
    EndIf
    setcolorex($32, $32, $32)
    rect((Int (((Float local0) * local1) + (Float arg0))), arg1, (Int local2), (Int local2), $00)
    Return $00
End Function
