Function playerloadedinfo%(arg0.mp_player)
    setplayertagfont(arg0, $00, "Tahoma")
    setplayertagscale(arg0, $00, 0.213, 0.026)
    setplayertagoffset(arg0, $00, 0.8)
    setplayertagcolors(arg0, $00, converttorgb($82, $82, $82), converttorgb($82, $82, $82))
    setplayertagtext(arg0, $00, arg0\Field6)
    setplayertagfont(arg0, $01, "Icons")
    setplayertagscale(arg0, $01, 0.213, 0.026)
    setplayertagoffset(arg0, $01, 0.88)
    setplayertagcolors(arg0, $01, converttorgb($82, $82, $82), converttorgb($82, $82, $82))
    setplayertagtext(arg0, $01, "")
    Return $00
End Function
