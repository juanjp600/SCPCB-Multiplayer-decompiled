Function checkdefaultdirectories%()
    Local local0$
    Restore DATA_00000000
    Repeat
        Read local0
        If (local0 = "15790320") Then
            Exit
        EndIf
        If (filesize(local0) = $00) Then
            createdir(local0)
        EndIf
    Forever
    Return $00
End Function
