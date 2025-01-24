Function mp_auth%()
    Local local0.mp_playerauth
    For local0 = Each mp_playerauth
        local0\Field2 = (local0\Field2 + mp_gettimestep())
        If (210.0 < local0\Field2) Then
            Delete local0
        EndIf
    Next
    Return $00
End Function
