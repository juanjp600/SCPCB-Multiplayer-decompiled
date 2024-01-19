Function findfreenpcid%()
    Local local0%
    For local0 = $01 To $FE Step $01
        If (m_npc[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
