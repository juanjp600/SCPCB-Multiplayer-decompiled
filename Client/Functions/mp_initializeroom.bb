Function mp_initializeroom%(arg0.rooms)
    Local local0%
    For local0 = $01 To $FF Step $01
        If (mp_rooms[local0] = Null) Then
            mp_rooms[local0] = arg0
            arg0\Field31 = local0
            Exit
        EndIf
    Next
    Return $00
End Function
