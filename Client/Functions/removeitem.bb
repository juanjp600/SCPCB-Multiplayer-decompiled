Function removeitem%(arg0.items, arg1%)
    Local local0%
    Local local2%
    Local local3%
    freeentity(arg0\Field2)
    freeentity(arg0\Field1)
    arg0\Field1 = $00
    For local0 = $00 To $09 Step $01
        If (inventory(local0) = arg0) Then
            debuglog(((("Removed " + arg0\Field3\Field1) + " from slot ") + (Str local0)))
            inventory(local0) = Null
            itemamount = (itemamount - $01)
            Exit
        EndIf
    Next
    If (selecteditem = arg0) Then
        Select selecteditem\Field3\Field2
            Case "nvgoggles","supernv"
                wearingnightvision = $00
            Case "gasmask","supergasmask","gasmask2","gasmask3"
                wearinggasmask = $00
            Case "vest","finevest","veryfinevest"
                wearingvest = $00
            Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                wearinghazmat = $00
            Case "scp714"
                wearing714 = $00
            Case "scp1499","super1499"
                wearing1499 = $00
            Case "scp427"
                i_427\Field0 = $00
        End Select
        selecteditem = Null
    EndIf
    If (eqquipedgun <> Null) Then
        If (arg0\Field22 = myplayer\Field0) Then
            If (isagun(arg0\Field3\Field2) <> 0) Then
                local2 = $00
                For local3 = $00 To $09 Step $01
                    If (((inventory(local3) <> Null) And (inventory(local3) <> arg0)) <> 0) Then
                        If (isagun(arg0\Field3\Field2) = isagun(inventory(local3)\Field3\Field2)) Then
                            local2 = $01
                            Exit
                        EndIf
                    EndIf
                Next
                If (local2 = $00) Then
                    eqquipedgun = Null
                    selecteditem = Null
                EndIf
            EndIf
        EndIf
    EndIf
    If (arg0\Field3\Field12 <> $00) Then
        freeimage(arg0\Field3\Field12)
        arg0\Field3\Field12 = $00
    EndIf
    If (((udp_network\Field0 <> $00) And (arg1 = $01)) <> 0) Then
        udp_bytestreamwritechar($2C)
        udp_bytestreamwriteshort(arg0\Field18)
        udp_setmicrobyte($2C)
    EndIf
    m_item[arg0\Field18] = Null
    Delete arg0
    Return $00
End Function
