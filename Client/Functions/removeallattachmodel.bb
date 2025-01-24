Function removeallattachmodel%()
    Local local0.mp_attachmodel
    Local local1%
    For local0 = Each mp_attachmodel
        For local1 = $00 To $3F Step $01
            If (local0\Field9[local1] <> Null) Then
                Delete local0\Field9[local1]
            EndIf
        Next
        Delete local0
    Next
    Return $01
    Return $00
End Function
