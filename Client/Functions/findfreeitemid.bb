Function findfreeitemid%()
    Local local0%
    For local0 = $01 To $3E7 Step $01
        If (m_item[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
