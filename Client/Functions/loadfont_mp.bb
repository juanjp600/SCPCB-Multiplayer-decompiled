Function loadfont_mp%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    If (filesize(arg0) = $00) Then
        Return loadfont_strict(fontpath("Arial"), arg1, arg2, arg3, arg4)
    Else
        local0 = loadfont(arg0, arg1, arg2, arg3, arg4)
        If (local0 <> $00) Then
            Return local0
        Else
            Return loadfont_strict(fontpath("Arial"), arg1, arg2, arg3, arg4)
        EndIf
    EndIf
    Return $00
End Function
