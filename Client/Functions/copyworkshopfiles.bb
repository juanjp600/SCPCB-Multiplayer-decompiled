Function copyworkshopfiles%(arg0$)
    If (filetype(arg0) > $00) Then
        workshopcopydirectory(arg0, "workshop\", $1B326C)
        scanworkshopfiles("workshop")
        ws_loadscripts("workshop")
    Else
        scanworkshopfiles("workshop")
    EndIf
    Return $00
End Function
