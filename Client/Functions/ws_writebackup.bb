Function ws_writebackup%(arg0$)
    Local local0%
    Local local1%
    createdirectories("workshop\languages\")
    createdirectories("workshop\backups\")
    If (filetype("workshop\backups\backup.data") <> $01) Then
        createfile("workshop\backups\backup.data")
    EndIf
    If (filetype(("workshop\backups\" + arg0)) = $00) Then
        local0 = openfile("workshop\backups\backup.data")
        If (local0 <> $00) Then
            seekfile(local0, filesize("workshop\backups\backup.data"))
            For local1 = $01 To len(arg0) Step $01
                writeint(local0, (asc(mid(arg0, local1, $01)) Shl $0A))
            Next
            writeint(local0, $3400)
            writeint(local0, $2800)
            closefile(local0)
            closefile(writefiledir(("workshop\backups\" + arg0)))
            deletefile(("workshop\backups\" + arg0))
            copyfile(arg0, ("workshop\backups\" + arg0))
            Return $01
        EndIf
    EndIf
    Return $00
    Return $00
End Function
