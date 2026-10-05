Function discord_api_update%()
    If (discordactive <> 0) Then
        If (millisecs() > discordcooldown) Then
            If ((mainmenuopen Or gameload) <> 0) Then
                If ((mainmenuopen And (gameload = $00)) <> 0) Then
                    If (discordlastdetails <> "Browsing the menus") Then
                        blitzcordsetactivitydetails("Browsing the menus")
                        blitzcordsetactivitystate("")
                        blitzcordsetlargetext("")
                        blitzcordsetsmallimage("")
                        blitzcordsettimestampstart(blitzcordgetcurrenttimestamp())
                        blitzcordupdateactivity()
                        discordcooldown = (millisecs() + $1388)
                        discordlaststatus = ""
                        discordlastdetails = "Browsing the menus"
                    EndIf
                ElseIf ((iscoopmode() And udp_getstream()) <> 0) Then
                    If (((discordlastdetails <> "Loading into a coop game") Or (discordlaststatus <> (("Loaded in " + (Str currentpercent)) + "/100"))) <> 0) Then
                        blitzcordsetactivitydetails("Loading into a coop game")
                        blitzcordsetactivitystate((("Loaded in" + (Str currentpercent)) + "/100"))
                        blitzcordsetlargetext("")
                        blitzcordsetsmallimage("")
                        blitzcordupdateactivity()
                        discordcooldown = (millisecs() + $3E8)
                        discordlaststatus = (("Loaded in" + (Str currentpercent)) + "/100")
                        discordlastdetails = "Loading into a coop game"
                    EndIf
                ElseIf (iscoopmode() <> 0) Then
                    If (((discordlastdetails <> "Loading into a singleplayer game") Or (discordlaststatus <> (("Loaded in " + (Str currentpercent)) + "/100"))) <> 0) Then
                        blitzcordsetactivitydetails("Loading into a singleplayer game")
                        blitzcordsetactivitystate((("Loaded in" + (Str currentpercent)) + "/100"))
                        blitzcordsetlargetext("")
                        blitzcordsetsmallimage("")
                        blitzcordupdateactivity()
                        discordcooldown = (millisecs() + $3E8)
                        discordlaststatus = (("Loaded in" + (Str currentpercent)) + "/100")
                        discordlastdetails = "Loading into a singleplayer game"
                    EndIf
                ElseIf (networkserver\Field12 <> 0) Then
                    If (((discordlastdetails <> ("Loading into " + networkserver\Field52\Field0)) Or (discordlaststatus <> (("Loaded in " + (Str currentpercent)) + "/100"))) <> 0) Then
                        blitzcordsetactivitydetails(("Loading into " + networkserver\Field52\Field0))
                        blitzcordsetactivitystate((("Loaded in" + (Str currentpercent)) + "/100"))
                        blitzcordsetlargetext("")
                        blitzcordsetsmallimage("")
                        blitzcordupdateactivity()
                        discordcooldown = (millisecs() + $3E8)
                        discordlaststatus = (("Loaded in" + (Str currentpercent)) + "/100")
                        discordlastdetails = ("Loading into " + networkserver\Field52\Field0)
                    EndIf
                EndIf
            ElseIf ((iscoopmode() And udp_getstream()) <> 0) Then
                If (((discordlastdetails <> "Playing Coop") Or ((((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")") <> discordlaststatus)) <> 0) Then
                    blitzcordsetactivitydetails("Playing Coop")
                    blitzcordsetactivitystate((((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")"))
                    blitzcordsetlargetext("")
                    blitzcordsetsmallimage("")
                    blitzcordsettimestampstart(blitzcordgetcurrenttimestamp())
                    blitzcordupdateactivity()
                    discordcooldown = (millisecs() + $1388)
                    discordlaststatus = (((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")")
                    discordlastdetails = "Playing Coop"
                EndIf
            ElseIf (iscoopmode() <> 0) Then
                If (discordlastdetails <> "Playing Singleplayer") Then
                    blitzcordsetactivitydetails("Playing Singleplayer")
                    blitzcordsetactivitystate("")
                    blitzcordsetlargetext("")
                    blitzcordsetsmallimage("")
                    blitzcordsettimestampstart(blitzcordgetcurrenttimestamp())
                    blitzcordupdateactivity()
                    discordcooldown = (millisecs() + $1388)
                    discordlaststatus = ""
                    discordlastdetails = "Playing Singleplayer"
                EndIf
            ElseIf (networkserver\Field12 <> 0) Then
                If (((discordlastdetails <> ("Playing on " + networkserver\Field52\Field0)) Or ((((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")") <> discordlaststatus)) <> 0) Then
                    blitzcordsetactivitydetails(("Playing on " + networkserver\Field52\Field0))
                    blitzcordsetactivitystate((((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")"))
                    blitzcordsetlargetext("")
                    blitzcordsetsmallimage("")
                    blitzcordsettimestampstart(blitzcordgetcurrenttimestamp())
                    blitzcordupdateactivity()
                    discordcooldown = (millisecs() + $1388)
                    discordlaststatus = (((("Lobby (" + (Str networkserver\Field21)) + "/") + (Str networkserver\Field52\Field14)) + ")")
                    discordlastdetails = ("Playing on " + networkserver\Field52\Field0)
                EndIf
            EndIf
        EndIf
        blitzcordruncallbacks()
    EndIf
    Return $00
End Function
