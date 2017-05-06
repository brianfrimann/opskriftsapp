# Opskriftsapp
Opskriftsapp er en app udviklet af Brian Frimann ifm. eksamen i Programmering til mobile enheder på CPH Business

## Overblik
Denne README.md er også rapporten for projektet og indeholder følgende punkter:

* Download fra GitHub
* Funktionaliteter
* Konklusion
* Perspektivering

## Download fra GitHub
Projektet ligge på GitHub og kan downloades eller clones via [github.com/brianfrimann/opskriftsapp/](https://github.com/brianfrimann/opskriftsapp/)

## Funktionaliteter
### Opbygning
Opskriftsapp består af tre aktiviteter; en med liste over opskrifter, en med selve opskriften og en med ingrediensliste

### Liste over opskrifter
Listen over opskrifter indeholder et listview med navn på opskrift og kategori.

### Opskriften
Opskriften indeholder navn på opskriften og kategori samt mulighed for at ændre disse.

Derudover indeholder den et listview med de enkelte delelementer og timer på disse.

Har kigget en del på at få lavet timeren, bl.a. andet via TimerTask, men kunne ikke få det til at virke.

Så endte med at lave en tråd som sover i den tid

´´´ kotlin
view.startTimerButton.onClick {
            doAsync {
                Thread.sleep(view.editTime.text.toString().toLong()*60*1000)
                uiThread {
                    context.toast("Tiden er nu gået ${view.editName.text}")
                    context.vibrator.vibrate(3000)
                    r.play()
                }
            }
        }
´´´



## Konklusion

## Perspektivering
