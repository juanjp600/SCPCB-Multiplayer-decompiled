Function objects_stream_update%()
    Local local0.players
    For local0 = Each players
        local0\Field52 = (local0\Field52 + $01)
    Next
    Return $00
End Function
