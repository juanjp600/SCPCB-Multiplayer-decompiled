Function voice_getbytes%()
    Return (opus_get_default_frame_size() Shl $01)
    Return $00
End Function
