Function findfreeeventid%()
    Local local0%
    For local0 = $01 To $6D Step $01
        If (m_event[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
