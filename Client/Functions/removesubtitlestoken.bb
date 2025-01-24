Function removesubtitlestoken%(arg0.sound)
    Local local0.queuedsubtitlesmsg
    For local0 = Each queuedsubtitlesmsg
        If (local0\Field2 = arg0) Then
            Delete local0
        EndIf
    Next
    Return $00
End Function
