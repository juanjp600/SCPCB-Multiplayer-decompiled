Function mp_flushsounds%()
    Local local0.mp_sound
    For local0 = Each mp_sound
        mp_flushsound(local0)
    Next
    Return $00
End Function
