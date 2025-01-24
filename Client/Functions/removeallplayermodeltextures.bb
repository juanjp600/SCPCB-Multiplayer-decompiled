Function removeallplayermodeltextures%()
    Local local0.mp_modeltexture
    For local0 = Each mp_modeltexture
        removeplayermodeltexture(local0\Field0)
    Next
    Return $00
End Function
