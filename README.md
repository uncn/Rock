# Rock

[![](https://jitpack.io/v/ShortStickBoy/Rock.svg)](https://jitpack.io/#ShortStickBoy/Rock)
[![](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

### ScreenShot
![sample](./screenshot/Demo.gif)

### Gradle
```groovy
dependencies {
    compile 'com.github.ShortStickBoy:Rock:V1.0.0'
}
```

### Use
```groovy
<com.sunzn.rock.library.RackVew
    android:id="@+id/rv"
    android:layout_width="match_parent"
    android:layout_height="250dp"
    android:background="@drawable/bg"
    app:rv_circle_fill_color="#20FFFFFF"
    app:rv_gap_circle_square="4"
    app:rv_max_circle_radius="10"
    app:rv_per_circle_update="150" />
```

| Attribute            | Describe                                   | Additional                           |
| -------------------- | ------------------------------------------ | ------------------------------------ |
| rv_min_circle_radius | The radius of the outer round rect         | Support dimension and reference      |
| rv_max_circle_radius | The Fill color of the outer round rect     | Support color                        |
| rv_gap_circle_square | The radius of the outer notch circle       | Support dimension and reference      |
| rv_ver_circle_number | The color of the outer notch circle        | Support color                        |
| rv_per_circle_update | The gap between the inner and outer layers | Support float                        |
| rv_circle_fill_color | The radius of the inner round rect         | Support dimension and reference      |

### License
```
Copyright [2017-2018] sunzn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```