Function sound_onkill%()
    Local local0.sounds
    Local local1.stream
    For local0 = Each sounds
        freesound_strict((Handle local0))
    Next
    For local1 = Each stream
        stopstream_strict((Handle local1))
    Next
    Delete Each sounds
    Delete Each stream
    Return $00
End Function
