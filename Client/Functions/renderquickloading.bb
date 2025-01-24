Function renderquickloading%()
    Local local0%
    If (((quickloadpercent > $FFFFFFFF) And opt\Field32) <> 0) Then
        local0 = (Int (90.0 * menuscale))
        midhandle(t\Field0[$09])
        drawimage(t\Field0[$09], (opt\Field46 - local0), (Int ((Float opt\Field47) - (150.0 * menuscale))), $00)
        color($FF, $FF, $FF)
        setfontex(fo\Field0[$00])
        textex((Int ((Float opt\Field46) - (100.0 * menuscale))), (opt\Field47 - local0), format(getlocalstring("loading", "loading"), (Str quickloadpercent), "%s"), $01, $00)
    EndIf
    Return $00
End Function
