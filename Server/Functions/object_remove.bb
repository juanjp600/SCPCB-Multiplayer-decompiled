Function object_remove%(arg0%)
    Local local0.players
    For local0 = Each players
        local0\Field54 = (local0\Field54 + $01)
    Next
    Delete multiplayer_object[arg0]
    Return $00
End Function
