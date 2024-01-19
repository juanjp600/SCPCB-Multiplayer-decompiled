Function drawachvimg%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1#
    Local local2%
    local1 = ((Float graphicheight) / 768.0)
    local2 = (Int (76.0 * local1))
    local0 = (arg2 Mod $04)
    color($00, $00, $00)
    rect(((local0 * local2) + arg0), arg1, (Int (64.0 * local1)), (Int (64.0 * local1)), $01)
    If (achievements(arg2) = $01) Then
        drawimage(achvimg(arg2), ((local0 * local2) + arg0), arg1, $00)
    Else
        drawimage(achvlocked, ((local0 * local2) + arg0), arg1, $00)
    EndIf
    color($32, $32, $32)
    rect(((local0 * local2) + arg0), arg1, (Int (64.0 * local1)), (Int (64.0 * local1)), $00)
    Return $00
End Function
