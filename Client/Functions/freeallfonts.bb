Function freeallfonts%(arg0%, arg1%)
    Local local0.aafont
    Local local1.loadedfonts
    For local0 = Each aafont
        If (arg1 = $00) Then
            aafreefont((Handle local0))
        Else
            Delete local0
        EndIf
    Next
    For local1 = Each loadedfonts
        If (local1\Field6 <> 0) Then
            freefont(local1\Field5)
        EndIf
    Next
    Delete Each loadedfonts
    If (arg0 <> 0) Then
        Delete Each redirectfont
    EndIf
    If (arg1 = $00) Then
        If (aatextenable = $00) Then
            If (aatextcam <> $00) Then
                freeentity(aatextcam)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
