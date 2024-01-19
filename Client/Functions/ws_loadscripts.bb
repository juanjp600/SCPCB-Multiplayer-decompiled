Function ws_loadscripts%(arg0$)
    Local local0%
    Local local1$
    Local local2$
    Local local3%
    Local local4%
    Local local5.workshopthread
    local0 = readdir(arg0)
    If (local0 <> $00) Then
        Repeat
            local1 = nextfile(local0)
            If (local1 = "") Then
                Exit
            EndIf
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                If (filetype(((arg0 + "\") + local1)) = $02) Then
                    If (((arg0 + "\") + local1) <> "workshop\backups") Then
                        local3 = readdir(((arg0 + "\") + local1))
                        Repeat
                            local2 = nextfile(local3)
                            If (local2 = "") Then
                                Exit
                            EndIf
                            If (((local2 <> ".") And (local2 <> "..")) <> 0) Then
                                local4 = $00
                                For local5 = Each workshopthread
                                    If (local5\Field0 = ((((arg0 + "\") + local1) + "\") + local2)) Then
                                        local4 = $01
                                        Exit
                                    EndIf
                                Next
                                If (local4 = $00) Then
                                    If (se_isvalidscript(local2) <> 0) Then
                                        ws_loadscript(((((arg0 + "\") + local1) + "\") + local2))
                                    EndIf
                                EndIf
                            EndIf
                        Forever
                        closedir(local3)
                    EndIf
                EndIf
            EndIf
        Forever
        closedir(local0)
    EndIf
    Return $00
End Function
