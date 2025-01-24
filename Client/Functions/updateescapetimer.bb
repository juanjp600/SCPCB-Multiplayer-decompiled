Function updateescapetimer%()
    Local local0.events
    For local0 = Each events
        If (local0\Field0 = $04) Then
            If (local0\Field1 = playerroom) Then
                Return $00
                Exit
            EndIf
        EndIf
    Next
    escapesecondstimer = (escapesecondstimer - fps\Field7[$00])
    If (0.0 >= escapesecondstimer) Then
        escapetimer = (escapetimer + $01)
        escapesecondstimer = 70.0
    EndIf
    Return $00
End Function
