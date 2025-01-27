Function initsubtitlesassets%()
    subassets = (New subtitlesassets)
    subassets\Field3 = ((Float opt\Field49) * 0.75)
    subassets\Field4 = ((Float (mo\Field9 + $01)) - (subassets\Field3 / 2.0))
    subassets\Field5 = ((Float opt\Field50) * 0.82)
    setfontex(fo\Field0[$00])
    subassets\Field0 = (Int ((Float fontheight()) * 2.5))
    Return $00
End Function
