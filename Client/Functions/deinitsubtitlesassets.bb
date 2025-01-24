Function deinitsubtitlesassets%()
    Local local0.sound
    For local0 = Each sound
        removesubtitlestoken(local0)
    Next
    Delete subassets
    subassets = Null
    Return $00
End Function
