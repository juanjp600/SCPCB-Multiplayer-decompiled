Function ws_checksubscribeditems%(arg0%)
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local5%
    Local local6%
    Local local7%
    If (filetype("workshop") = $00) Then
        createdir("workshop")
    EndIf
    If (filetype("workshop\languages") = $00) Then
        createdir("workshop\languages")
    EndIf
    local0 = currentworkshopuploadingitems
    If (bs_steamugc_getnumsubscribeditems(bs_steamugc()) > $00) Then
        currentworkshopuploadingitems = $00
        local2 = bs_steamugc_getsubscribeditems(bs_steamugc())
        For local3 = $00 To (Int min((Float (bs_steamugc_getnumsubscribeditems(bs_steamugc()) - $01)), 1024.0)) Step $01
            Select bs_steamugc_getitemstate(bs_steamugc(), ((local3 Shl $03) + local2))
                Case $05
                    If (arg0 <> 0) Then
                        local5 = createbank($04)
                        local6 = createbank($200)
                        local7 = createbank($04)
                        bs_steamugc_getiteminstallinfo(bs_steamugc(), ((local3 Shl $03) + local2), local5, local6, banksize(local6), local7)
                        local1 = strippreviouspath(c_str(local6), $01)
                        freebank(local5)
                        freebank(local6)
                        freebank(local7)
                    EndIf
                Case $09,$0D
                    bs_steamugc_downloaditem(bs_steamugc(), ((local3 Shl $03) + local2), $01)
                    currentworkshopdownloaditems = (currentworkshopdownloaditems + $01)
                Case $19
                    currentworkshopuploadingitems = (currentworkshopuploadingitems + $01)
            End Select
        Next
        If (((arg0 And (local1 <> "")) Or (currentworkshopuploadingitems <> local0)) <> 0) Then
            copyworkshopfiles(local1)
        EndIf
    EndIf
    If ((arg0 Or (currentworkshopuploadingitems <> local0)) <> 0) Then
        copyworkshopfiles(local1)
    EndIf
    Return $00
End Function
