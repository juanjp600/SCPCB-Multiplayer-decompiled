Function freeallfonts%()
    Local local0%
    For local0 = $00 To $06 Step $01
        freefontex(fonts[local0])
    Next
    Return $00
End Function
