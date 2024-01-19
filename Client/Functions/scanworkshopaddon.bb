Function scanworkshopaddon%(arg0$)
    Local local0%
    Local local1$
    Local local2%
    Local local3$
    Local local4%
    local0 = readdir(arg0)
    If (local0 <> $00) Then
        Repeat
            local1 = nextfile(local0)
            If (local1 = "") Then
                Exit
            EndIf
            If (filetype(((arg0 + "\") + local1)) = $02) Then
                If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                    local1 = removesamechars(((arg0 + "\") + local1), "\")
                    local3 = replace(local1, "workshop\", "")
                    For local4 = $00 To (currentscanneddirsignore - $01) Step $01
                        If (instr(local3, scanneddirignore[local4], $01) <> 0) Then
                            local3 = ""
                            Exit
                        EndIf
                    Next
                    If (local3 <> "") Then
                        scanworkshopaddon(local1)
                        local2 = $00
                        For local4 = $00 To (currentscanneddirs - $01) Step $01
                            If (scanneddir[local4] <> "") Then
                                If (instr(scanneddir[local4], local3, $01) <> $00) Then
                                    local2 = $01
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local2 = $00) Then
                            deletedir(local1)
                        EndIf
                    EndIf
                EndIf
            Else
                local1 = removesamechars(((arg0 + "\") + local1), "\")
                local3 = replace(local1, "workshop\", "")
                For local4 = $00 To (currentscanneddirsignore - $01) Step $01
                    If (instr(local3, scanneddirignore[local4], $01) <> 0) Then
                        local3 = ""
                        Exit
                    EndIf
                Next
                If (local3 <> "") Then
                    local2 = $00
                    For local4 = $00 To (currentscannedfiles - $01) Step $01
                        If (scanneddirfiles[local4] <> "") Then
                            If (instr(scanneddirfiles[local4], local3, $01) <> $00) Then
                                local2 = $01
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local2 = $00) Then
                        deletefile(local1)
                    EndIf
                EndIf
            EndIf
        Forever
        closedir(local0)
    EndIf
    Return $00
End Function
