Function mp_updaterooms%()
    Local local0.rooms
    roomsanalyzetime = (roomsanalyzetime - fps\Field7[$00])
    If (0.0 >= roomsanalyzetime) Then
        For local0 = Each rooms
            mp_analyzeroomobjects(local0)
            mp_analyzeroomlevers(local0)
        Next
        roomsanalyzetime = 35.0
    EndIf
    Return $00
End Function
