Function ws_backuporiginal%()
    Local local0%
    Local local1$
    Local local2%
    createdirectories("workshop\languages\")
    createdirectories("workshop\backups\")
    local0 = readfile("workshop\backups\backup.data")
    If (local0 <> $00) Then
        While (eof(local0) = $00)
            local1 = ""
            While (eof(local0) = $00)
                local2 = (readint(local0) Sar $0A)
                If (((local2 = $0A) Or (local2 = $00)) <> 0) Then
                    Exit
                EndIf
                If (local2 <> $0D) Then
                    local1 = (local1 + chr(local2))
                EndIf
            Wend
            deletefile(local1)
            copyfile(("workshop\backups\" + local1), local1)
            deletefile(("workshop\backups\" + local1))
        Wend
        closefile(local0)
        deletefile("workshop\backups\backup.data")
    EndIf
    Return $00
End Function
