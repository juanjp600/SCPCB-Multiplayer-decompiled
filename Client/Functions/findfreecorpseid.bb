Function findfreecorpseid%()
    Local local0%
    For local0 = $01 To $FF Step $01
        If (m_corpse[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
