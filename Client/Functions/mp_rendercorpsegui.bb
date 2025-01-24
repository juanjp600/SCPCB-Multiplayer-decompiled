Function mp_rendercorpsegui%()
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    If (selectedcorpse <> Null) Then
        color($FF, $FF, $FF)
        local0 = (Int (300.0 * menuscale))
        local1 = (Int (20.0 * menuscale))
        local2 = (Float (mo\Field9 - (local0 Sar $01)))
        local3 = ((Float mo\Field10) + (80.0 * menuscale))
        renderbar(blinkmeterimg, (Int local2), (Int local3), local0, local1, selectedcorpse\Field17, 100.0, $64, $64, $64)
    EndIf
    Return $00
End Function
