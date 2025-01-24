Function event_isplayerinroom%(arg0.events)
    Return ((playerroom = arg0\Field1) Lor (event_prevplayerroom = arg0\Field1))
    Return $00
End Function
