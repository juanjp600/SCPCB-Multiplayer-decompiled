Function scanworkshopfiles%(arg0$)
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    local0 = readdir(arg0)
    addscannedpath("backups", $01)
    addscannedpath("languages", $01)
    addscannedpath("youraddons", $01)
    addscannedpathignore("backups", $01)
    addscannedpathignore("languages", $01)
    addscannedpathignore("youraddons", $01)
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
            If (filetype(((arg0 + "\") + local1)) = $02) Then
                local2 = $00
                For local3 = $00 To (currentscanneddirs - $01) Step $01
                    If (scanneddir[local3] <> "") Then
                        If (instr(scanneddir[local3], local1, $01) <> 0) Then
                            local2 = $01
                            Exit
                        EndIf
                    EndIf
                Next
                If (local2 = $00) Then
                    scanandcleardir(((arg0 + "\") + local1), "", "", "", $00)
                    deletedir(((arg0 + "\") + local1))
                Else
                    scanworkshopaddon(((arg0 + "\") + local1))
                EndIf
            EndIf
        EndIf
    Forever
    clearscannedpath()
    Return $00
End Function
