Function oniteminstalled%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    If (resultworkshop = $00) Then
        resultworkshop = bp_getfunctionpointer()
        Return $00
    EndIf
    If (bs_memory_peekint(arg0, $00) = $1B326C) Then
        local0 = createbank($04)
        local1 = createbank($200)
        local2 = createbank($04)
        bs_steamugc_getiteminstallinfo(bs_steamugc(), (arg0 + $08), local0, local1, banksize(local1), local2)
        local3 = strippreviouspath(c_str(local1), $01)
        freebank(local0)
        freebank(local1)
        freebank(local2)
        If (local3 <> "") Then
            copyworkshopfiles(local3)
        EndIf
        currentworkshopdownloaditems = (Int max((Float (currentworkshopdownloaditems - $01)), 0.0))
    EndIf
    Return $00
End Function
